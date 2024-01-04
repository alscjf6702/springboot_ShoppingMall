package com.shop.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.shop.constant.ItemSellStatus;
import com.shop.entity.Item;
import com.shop.entity.QItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.TestPropertySource;
import org.thymeleaf.util.StringUtils;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class ItemRepositoryTests {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    EntityManager em;

    @Test
    @DisplayName("상품 저장 테스트")
    public void createItemTest() {
        Item item = new Item();
        item.setItemNm("상품명1");
        item.setItemDetail("상품 설명");
        item.setPrice(10000);
        item.setStockNumber(44);
        item.setItemSellStatus(ItemSellStatus.SELL);
        item.setRegTime(LocalDateTime.now());
        item.setUpdateTime(LocalDateTime.now());

        Item savedItem = itemRepository.save(item);
        System.out.println(savedItem.toString());
    }

    public void createItems() {
        for (int i = 1; i <= 10; i++) {
            Item item = new Item();
            item.setItemNm("상품명" + i);
            item.setItemSellStatus(ItemSellStatus.SELL);
            item.setPrice(i * 2000);
            item.setStockNumber(i * 21);
            item.setItemDetail("상품 설명" + i);
            item.setRegTime(LocalDateTime.now());
            item.setUpdateTime(LocalDateTime.now());

            Item savedItem = itemRepository.save(item);
        }
    }

    @Test
    @DisplayName("Query메서드 이용한 조회")
    public void itemListTest() {
        this.createItems();
        List<Item> itemList = itemRepository.findByItemNm("상품명3");
        for (Item item : itemList) {
            System.out.println(item.toString());
        }
    }


    @Test
    @DisplayName("모두 조회")
    public void findAll() {
        this.createItems();
        List<Item> itemList = itemRepository.findAll();
        for (Item item : itemList) {
            System.out.println(item.toString());
        }
    }

    @Test
    @DisplayName("가격 조회")
    public void findByPrice(){
        this.createItems();
        List<Item> itemList = itemRepository.findByPrice(4000);

        for (Item item : itemList) {
            System.out.println(item);
        }
    }

    @Test
    @DisplayName("QueryDsl조회 테스트")
    public void querydslTest(){
        this.createItems();
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QItem qItem = QItem.item;
        JPAQuery<Item> query = queryFactory.selectFrom(qItem)
                .where(qItem.itemNm.eq("상품명7"))
                .orderBy(qItem.price.desc());

        List<Item> itemList = query.fetch();

        for (Item item : itemList) {
            System.out.println(item.toString());
        }

    }

    public void createItemList(){
        for (int i = 1; i <= 5; i++) {
            Item item = new Item();
            item.setItemNm("상품명"+i);
            item.setItemDetail("상품설명"+i);
            item.setPrice(2000*i);
            item.setItemSellStatus(ItemSellStatus.SELL);
            item.setStockNumber(37*i);
            item.setRegTime(LocalDateTime.now());
            item.setUpdateTime(LocalDateTime.now());
            itemRepository.save(item);
        }

        for (int i = 6; i <= 10; i++) {
            Item item = new Item();
            item.setItemNm("상품명"+i);
            item.setItemDetail("상품설명"+i);
            item.setPrice(2000*i);
            item.setItemSellStatus(ItemSellStatus.SOLD_OUT);
            item.setStockNumber(37*i);
            item.setRegTime(LocalDateTime.now());
            item.setUpdateTime(LocalDateTime.now());
            itemRepository.save(item);
        }
    }

    @Test
    @DisplayName("QueryDSLPredicateExcutor")
    public void queryDSLTest2(){
        this.createItemList();

        BooleanBuilder booleanBuilder = new BooleanBuilder();
        QItem item = QItem.item;

        String itemDetail = "상품설명";
        int price = 6000;
        String itemSellStat = "SELL";

        booleanBuilder.and(item.itemDetail.like("%" + itemDetail + "%"));
        booleanBuilder.and(item.price.goe(price));

        if (StringUtils.equals(itemSellStat, ItemSellStatus.SELL)) {
            booleanBuilder.and(item.itemSellStatus.eq(ItemSellStatus.SELL));
        }

        Pageable pageable = PageRequest.of(0, 5);
        Page<Item> itemPagingResult = itemRepository.findAll(booleanBuilder, pageable);
        System.out.println("total elements : " + itemPagingResult.getTotalElements());

        List<Item> resultItemList = itemPagingResult.getContent();

        for (Item resultItem : resultItemList) {
            System.out.println(resultItem.toString());
        }
    }























}