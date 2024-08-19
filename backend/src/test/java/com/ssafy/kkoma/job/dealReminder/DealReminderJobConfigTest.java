package com.ssafy.kkoma.job.dealReminder;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.boot.test.context.SpringBootTest;

//@ActiveProfiles("test")
@Slf4j
@SpringBootTest
@SpringBatchTest
//@SpringJUnitConfig(classes = {SpringBatchTestConfig.class, DealReminderJobConfig.class})
class DealReminderJobConfigTest {

//    @Autowired
//    private JobLauncherTestUtils jobLauncherTestUtils;
//
//    @Autowired
//    MemberFactory memberFactory;
//    @Autowired
//    CategoryFactory categoryFactory;
//    @Autowired
//    OfferFactory offerFactory;
//    @Autowired
//    ProductFactory productFactory;
//
//    @Autowired
//    private DealRepository dealRepository;
//    @Autowired
//    private NotificationRepository notificationRepository;
//
//    @Autowired
//    OfferService offerService;
//
//    @Test
//    public void success() throws Exception {
//        int NUM = 3;
//
//        // given
//        for (int i = 1; i <= NUM; i++) createDeal(LocalDateTime.now().plusHours(1));
//        long befNotiCount = notificationRepository.count();
//
//        // when
//        log.info("[test] 현재 실행 중인 job은: {}", jobLauncherTestUtils.getJob().getName());
//        JobExecution execution = jobLauncherTestUtils.launchJob();
//
//        // then
//        Assertions.assertThat(execution.getExitStatus()).isEqualTo(ExitStatus.COMPLETED);
//        log.info("[test] deal은 {}개, noti는 {}개", dealRepository.count(), notificationRepository.count());
//        Assertions.assertThat(notificationRepository.count()).isGreaterThanOrEqualTo(befNotiCount + NUM * 2);
//    }
//
//    @Transactional
//    protected void createDeal(LocalDateTime dealTime) {
//        Member seller = memberFactory.createMember();
//        Member buyer = memberFactory.createMember();
//
//        Category category = categoryFactory.createCategory("목욕 용품");
//        Product product = productFactory.createProduct(seller, category, 20000);
//        Offer offer = offerFactory.createOffer(product, buyer);
//        DecideOfferRequest decideOfferRequest = DecideOfferRequest.builder().selectedTime(dealTime).build();
//        offerService.acceptOffer(offer.getId(), decideOfferRequest);
//    }
}