package com.codecool.terraformingmarsforum.sample_data;


import com.codecool.terraformingmarsforum.model.AppUser;
import com.codecool.terraformingmarsforum.model.LeagueDetail;
import com.codecool.terraformingmarsforum.model.LeaguePost;
import com.codecool.terraformingmarsforum.model.types.LeagueStatus;
import com.codecool.terraformingmarsforum.repository.AppUserRepository;
import com.codecool.terraformingmarsforum.repository.CommentRepository;
import com.codecool.terraformingmarsforum.repository.LeagueDetailRepository;
import com.codecool.terraformingmarsforum.service.LeaguePostService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
public class DataSampleInitializer {

    private final Logger logger = LoggerFactory.getLogger(DataSampleInitializer.class);
    private final AppUserRepository appUserRepository;
    private final CommentRepository commentRepository;
    private final LeagueDetailRepository leagueDetailRepository;
    private final LeaguePostService leaguePostService;
    private final String separator = "\n-----------------------------------------------------------\n";


    @PostConstruct
    private void initSampleData() {
        logger.info(separator + "Initialize Sample Data");
        createAppUser();
        createLeagueDetails();
        createLeaguePosts();
        logger.info("\nSample data initialized" + separator);
    }

    private void createAppUser() {
        logger.info("initialize " + AppUser.class.getSimpleName() + "s");
        appUserRepository.save(AppUser.builder()
                        .firstName("Bendegúz")
                        .lastName("Dudaskó")
                        .username("Grande Cruz")
                        .email("dudaskobendeguz@mars.com")
                        .password("1234")
                        .imgSource("https://scontent-vie1-1.xx.fbcdn.net/v/t31.18172-1/11952736_876155152421611_2331361888803138775_o.jpg?stp=dst-jpg_p200x200&_nc_cat=107&ccb=1-7&_nc_sid=7206a8&_nc_ohc=xbKnjdzTyB0AX-ATi0W&_nc_ht=scontent-vie1-1.xx&oh=00_AT9TNY0ewhJhQgIF6Fm5fc9qvT_0YNOgdIjP5wZmuGSpHQ&oe=633E55F3")
                        .timestamp(new Date())
                .build());
        appUserRepository.save(AppUser.builder()
                        .firstName("Bendek")
                        .lastName("Halaj")
                        .username("Frenedek")
                        .email("halajbenedek@mars.com")
                        .password("1234")
                        .imgSource("https://scontent-vie1-1.xx.fbcdn.net/v/t39.30808-1/296482344_1548369242283304_7205599809702472898_n.jpg?stp=c0.16.189.190a_dst-jpg_p200x200&_nc_cat=104&ccb=1-7&_nc_sid=7206a8&_nc_ohc=BxR9v2QWLsEAX-fi23S&_nc_ht=scontent-vie1-1.xx&oh=00_AT9FQH907BiiZLV1P8iTt71-rsYbvQX3mpTz2q-j45g_dg&oe=631F5E86")
                        .timestamp(new Date())
                .build());
        appUserRepository.save(AppUser.builder()
                        .firstName("Juhász")
                        .lastName("Zsuzsanna")
                        .username("Zsezsu")
                        .email("zsujuhasz@mars.com")
                        .password("1234")
                        .imgSource("https://scontent-vie1-1.xx.fbcdn.net/v/t1.6435-1/131748333_10157952376901045_4018821704944512624_n.jpg?stp=dst-jpg_p200x200&_nc_cat=105&ccb=1-7&_nc_sid=7206a8&_nc_ohc=AYdGWjWOzLgAX9Va4_O&_nc_ht=scontent-vie1-1.xx&oh=00_AT9jcTXIne64nXH7q6ZiM_Zh4LZmN80zF4A3NexET-vytw&oe=633F80B9")
                        .timestamp(new Date())
                .build());
        appUserRepository.save(AppUser.builder()
                        .firstName("Viktor")
                        .lastName("Sági")
                        .username("BigDoor")
                        .email("sagiviktor@mars.com")
                        .password("1234")
                        .imgSource("https://scontent-vie1-1.xx.fbcdn.net/v/t39.30808-1/297861816_2080795045641703_5449027322869902342_n.jpg?stp=c226.95.257.257a_dst-jpg_p480x480&_nc_cat=100&ccb=1-7&_nc_sid=7206a8&_nc_ohc=0eK2dEitQdMAX-OVslI&_nc_oc=AQk0QbkA-HkK8kY3J7fnsXcoSI0aNqyHsjE6WXnr1nW8dq5bOSkxXoIlCMsSK_lF_eY&_nc_ht=scontent-vie1-1.xx&oh=00_AT-pk2lVrdYsplut9_ZFC4XzHvbbLV_qzykR5jtDi5PdoQ&oe=631D7855")
                        .timestamp(new Date())
                .build());
        logger.info(AppUser.class.getSimpleName() + "s initialized");
    }

    private void createLeagueDetails() {
        logger.info("initialize " + LeagueDetail.class.getSimpleName() + "s");

        LeagueDetail leagueDetail = LeagueDetail.builder()
                .leagueId(1L)
                .name("First League")
                .gameType("Terraforming Mars")
                .timestamp(new Date())
                .leagueAdmin(appUserRepository.findById(1L).orElseThrow(NoSuchElementException::new))
                .players(appUserRepository.findAll())
                .numberOfRounds(4)
                .imageSource("https://m.blog.hu/di/diceandsorcery/image/terraforming_mars_magyar.jpg")
                .build();
        leagueDetailRepository.save(leagueDetail);

        logger.info(LeagueDetail.class.getSimpleName() + "s initialized");

    }

    private void createLeaguePosts() {
        logger.info("initialize " + LeaguePost.class.getSimpleName() + "s");

        LeagueDetail leagueDetail = leagueDetailRepository.findById(1L)
                .orElseThrow(NoSuchElementException::new);

        LeaguePost startedLeaguePost = LeaguePost.builder()
                .leagueDetail(leagueDetail)
                .numberOfFinishedRounds(0)
                .leagueStatus(LeagueStatus.STARTED)
                .timeStamp(new Date())
                .build();
        leaguePostService.save(startedLeaguePost);

        LeaguePost firstRoundStartedLeaguePost = LeaguePost.builder()
                .leagueDetail(leagueDetail)
                .numberOfFinishedRounds(0)
                .leagueStatus(LeagueStatus.ROUND_IN_PROGRESS)
                .timeStamp(new Date())
                .build();
        leaguePostService.save(firstRoundStartedLeaguePost);

        LeaguePost firstRoundFinishedLeaguePost = LeaguePost.builder()
                .leagueDetail(leagueDetail)
                .numberOfFinishedRounds(1)
                .leagueStatus(LeagueStatus.ROUND_FINISHED)
                .timeStamp(new Date())
                .build();
        leaguePostService.save(firstRoundFinishedLeaguePost);

        logger.info(LeaguePost.class.getSimpleName() + "s initialized");

    }
}
