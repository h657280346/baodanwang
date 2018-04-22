package com.yczc.ssm.controller;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.yczc.ssm.service.AboutService;
import com.yczc.ssm.service.AmessageService;
import com.yczc.ssm.service.BallteamService;
import com.yczc.ssm.service.CarouselService;
import com.yczc.ssm.service.CommentService;
import com.yczc.ssm.service.ContestService;
import com.yczc.ssm.service.NmessageService;
import com.yczc.ssm.service.NoticeService;
import com.yczc.ssm.service.PlayerService;
import com.yczc.ssm.service.RewardService;
import com.yczc.ssm.service.SubscriberService;
import com.yczc.ssm.service.YuezhanService;

@Component
public class Service {
	public static AboutService aboutService = null;
	
	public static  CarouselService carouselService=null;

	public static NoticeService noticeService = null;

	public static ContestService contestService = null;

	public static PlayerService playerService = null;

	public static RewardService rewardService = null;

	public static SubscriberService subscriberService = null;

	public static YuezhanService yuezhanService = null;
	
	public static CommentService commentService = null;
	
	public static BallteamService  ballteamService = null;
	
	public static AmessageService amessageService = null;
	
	public static NmessageService nmessageService = null;
	/**
	 * 
	 */
	public static Map<String,String> distanceMap=null;
	/**
	 * ����
	 */
	public static String lng = null;
	/**
	 * ά��
	 */
	public static String lat = null;
	
	public final static String[] url={"getContestBySearch.action","step4.action","step3.action","step2.action","step1.action","uploadNewPlayer.action","uploadOldSubscriber.action","uploadNewSubscriber.action","uploadOldBallteam.action","uploadNewBallteam.action","uploadComment.action","uploadAnswerCancelYuezhan.action","uploadAmessage.action","uploadDeleteNmessage.action","uploadCancelYuezhan.action","uploadDeleteYuezhan.action","uploadUpdateYuezhan.action","uploadYuezhan.action","uploadContest.action","uploadUpdateContest.action","getMyMessage.action","getAbout.action","getOtherYuzhanByOpenid.action","getMyYuzhanByOpenid.action","getMyComment.action","getContestDetail.action","getCarousel.action","getNotice.action","getContestIndex.action"};
	
	@Autowired  
	public  void setNmessageService(NmessageService nmessageService) {
		Service.nmessageService = nmessageService;
	}
	
	@Autowired  
	public  void setAmessageService(AmessageService amessageService) {
		Service.amessageService = amessageService;
	}
	
	@Autowired  
	public  void setBallteamService(BallteamService ballteamService) {
		Service.ballteamService = ballteamService;
	}

	@Autowired  
	public  void setCommentService(CommentService commentService) {
		Service.commentService = commentService;
	}
	
	@Autowired  
	public  void setCarouselService(CarouselService carouselService) {
		Service.carouselService = carouselService;
	}
	@Autowired  
	public  void setNoticeService(NoticeService noticeService) {
		Service.noticeService = noticeService;
	}
	@Autowired  
	public  void setContestService(ContestService contestService) {
		Service.contestService = contestService;
	}
	@Autowired  
	public  void setPlayerService(PlayerService playerService) {
		Service.playerService = playerService;
	}
	@Autowired  
	public  void setRewardService(RewardService rewardService) {
		Service.rewardService = rewardService;
	}
	@Autowired  
	public  void setSubscriberService(SubscriberService subscriberService) {
		Service.subscriberService = subscriberService;
	}
	@Autowired  
	public  void setYuezhanService(YuezhanService yuezhanService) {
		Service.yuezhanService = yuezhanService;
	}
	@Autowired  
	public  void setAboutService(AboutService aboutService) {
		Service.aboutService = aboutService;
	}

}
