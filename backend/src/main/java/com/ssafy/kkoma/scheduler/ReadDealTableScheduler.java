package com.ssafy.kkoma.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReadDealTableScheduler {

//    @Autowired
//    private Job readDealTableJob;
//
//    @Autowired
//    private JobLauncher jobLauncher;
//
//    private LocalDateTime lastRun = LocalDateTime.now();
//    private LocalDateTime curRun;
//
//    @Scheduled(cron = "0 */2 * * * *") // once per 2 minutes (at the top of the minute - the 0th second).
//    public void readDealTableJobRun() throws
//            JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException,
//            JobParametersInvalidException, JobRestartException
//    {
//        curRun = LocalDateTime.now();
//        log.info("[1/lastRun] {} ", lastRun);
//        log.info("[1/curRun] {}", curRun);
//
//        JobParameters jobParameters = new JobParametersBuilder()
//                .addLocalDateTime("lastRun", lastRun)
//                .addLocalDateTime("curRun", curRun)
//                .toJobParameters();
//
//        lastRun = curRun;
//        log.info("[2/lastRun] {} ", lastRun);
//        log.info("[2/curRun] {}", curRun);
//
//        jobLauncher.run(readDealTableJob, jobParameters);
//    }
}
