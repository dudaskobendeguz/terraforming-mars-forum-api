package com.codecool.terraformingmarsforum.service;

import com.codecool.terraformingmarsforum.model.AppUser;
import com.codecool.terraformingmarsforum.model.LeagueDetail;
import com.codecool.terraformingmarsforum.model.LeaguePost;
import com.codecool.terraformingmarsforum.model.LeaguePostModel;
import com.codecool.terraformingmarsforum.model.types.LeagueStatus;
import com.codecool.terraformingmarsforum.repository.LeaguePostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LeaguePostServiceTest {

    @Mock
    LeaguePostRepository mockLeaguePostRepository;

    LeaguePostService leaguePostService;

    private final Date expectedDate = new Date();
    private final Long expectedLeagueId = 1L;
    private final String expectedImageSource = "http://testPicture.test";
    private final String expectedEmail = "test@email.test";
    private final String expectedPassword = "1234";
    private final String expectedUsername = "Test Username";
    private final String expectedGameTye = "Test GameType";
    private final String expectedName = "Test Name";
    private final String expectedFirstName = "Test First Name";
    private final String expectedLastName = "Test Last Name";
    private final LeagueStatus defaultLeagueStatus = LeagueStatus.STARTED;
    private final int expectedNumberOfFinishedRounds = 1;
    private final int expectedNumberOfRounds = 5;
    private final Long expectedId = 1L;


    @BeforeEach
    private void initLeaguePostService() {
        leaguePostService = new LeaguePostService(mockLeaguePostRepository);
    }


    //-------------------------------------------Test save-------------------------------------------------------
    @Test
    public void  saveLeaguePost_SavingLeaguePost_ReturnSavedLeaguePostWIthNewId() {
        Long expected = 1L;
        LeaguePost leaguePost = mockLeaguePost(defaultLeagueStatus);

        LeaguePost leaguePostWithId = mockLeaguePost(defaultLeagueStatus);
        leaguePostWithId.setId(expected);

        when(mockLeaguePostRepository.save(leaguePost)).thenReturn(leaguePostWithId);

        Long actual = leaguePostService.save(leaguePost).getId();
        assertEquals(actual, expected);
    }


    //-------------------------------------------Test createDescription-----------------------------------------
    @Test
    public void createDescription_CreateDescription_CreateDescriptionForLeaguePostWithInProgressLeagueStatus() {
        String expected = String.format(
                "Round %d started!",
                (expectedNumberOfFinishedRounds + 1)
        );

        LeaguePost leaguePost = mockLeaguePost(LeagueStatus.ROUND_IN_PROGRESS);

        when(mockLeaguePostRepository.save(leaguePost)).thenReturn(leaguePost);

        String actual = leaguePostService.save(leaguePost).getDescription();

        assertEquals(expected, actual);
    }

    @Test
    public void createDescription_CreateDescription_CreateDescriptionForLeaguePostWithStartedLeagueStatus() {

        String expected = String.format(
                "%s has started a %s %s league!",
                expectedUsername,
                expectedGameTye,
                expectedName
                );

        LeaguePost leaguePost = mockLeaguePost(LeagueStatus.STARTED);

        when(mockLeaguePostRepository.save(leaguePost)).thenReturn(leaguePost);

        String actual = leaguePostService.save(leaguePost).getDescription();
        assertEquals(expected, actual);
    }

    @Test
    public void createDescription_CreateDescription_CreateDescriptionForLeaguePostWithRoundFinishedLeagueStatus() {
        String expected = String.format(
                "Round %d/%d finished",
                expectedNumberOfFinishedRounds,
                expectedNumberOfRounds
        );

        LeaguePost leaguePost = mockLeaguePost(LeagueStatus.ROUND_FINISHED);

        when(mockLeaguePostRepository.save(leaguePost)).thenReturn(leaguePost);

        String actual = leaguePostService.save(leaguePost).getDescription();

        assertEquals(expected, actual);
    }

    @Test
    public void createDescription_CreateDescription_CreateDescriptionForLeaguePostWithFinishedLeagueStatus() {
        String expected = String.format(
                "The %s %s league has finished!",
                expectedGameTye,
                expectedName
        );

        LeaguePost leaguePost = mockLeaguePost(LeagueStatus.FINISHED);

        when(mockLeaguePostRepository.save(leaguePost)).thenReturn(leaguePost);

        String actual = leaguePostService.save(leaguePost).getDescription();

        assertEquals(expected, actual);
    }


    //----------------------------------------------Test findAll----------------------------------------------

    @Test
    public void findAll_getAllLeaguePost_GetAllLeaguePostInLeaguePostDetailModelList() {
        LeaguePost leaguePost1 = mockLeaguePostWithLeagueAdminId(defaultLeagueStatus);
        LeaguePost leaguePost2 = mockLeaguePostWithLeagueAdminId(defaultLeagueStatus);
        List<LeaguePost> leaguePosts = List.of(leaguePost1, leaguePost2);

        when(mockLeaguePostRepository.findAll()).thenReturn(leaguePosts);

        LeaguePostModel leaguePostModel1 = mockLeaguePostModel();
        LeaguePostModel leaguePostModel2 = mockLeaguePostModel();
        List<LeaguePostModel> expected = List.of(leaguePostModel1, leaguePostModel2);

        List<LeaguePostModel> actual = leaguePostService.findAll();

        assertEquals(expected, actual);
    }

    private LeaguePostModel mockLeaguePostModel() {
        return LeaguePostModel.builder()
                .leagueId(expectedLeagueId)
                .leagueAdmin(mockAppUserWithId())
                .gameType(expectedGameTye)
                .name(expectedName)
                .timestamp(expectedDate)
                .imageSource(expectedImageSource)
                .numberOfComments(0)
                .numberOfPlayers(0)
                .numberOfRounds(expectedNumberOfRounds)
                .build();
    }


    private LeaguePost mockLeaguePost(LeagueStatus leagueStatus) {
        return LeaguePost.builder()
                .timeStamp(expectedDate)
                .leagueStatus(leagueStatus)
                .numberOfFinishedRounds(expectedNumberOfFinishedRounds)
                .leagueDetail(mockLeagueDetail())
                .comments(new ArrayList<>())
                .build();
    }

    private LeaguePost mockLeaguePostWithLeagueAdminId(LeagueStatus leagueStatus) {
        LeaguePost leaguePost = mockLeaguePost(leagueStatus);
        LeagueDetail leagueDetail = leaguePost.getLeagueDetail();
        AppUser leagueAdmin = leagueDetail.getLeagueAdmin();
        leagueAdmin.setId(expectedId);
        leagueDetail.setLeagueAdmin(leagueAdmin);
        leaguePost.setLeagueDetail(leagueDetail);
        return leaguePost;
    }

    private LeagueDetail mockLeagueDetail() {
        return LeagueDetail.builder()
                .leagueId(expectedLeagueId)
                .numberOfRounds(expectedNumberOfRounds)
                .name(expectedName)
                .gameType(expectedGameTye)
                .imageSource(expectedImageSource)
                .timestamp(expectedDate)
                .leagueAdmin(mockAppUser())
                .players(new ArrayList<>())
                .build();
    }

    private AppUser mockAppUser() {
        return AppUser.builder()
                .username(expectedUsername)
                .imageSource(expectedImageSource)
                .lastName(expectedLastName)
                .firstName(expectedFirstName)
                .email(expectedEmail)
                .password(expectedPassword)
                .timestamp(expectedDate)
                .build();
    }

    private AppUser mockAppUserWithId() {
        AppUser appUser = mockAppUser();
        appUser.setId(expectedId);
        return appUser;
    }
}