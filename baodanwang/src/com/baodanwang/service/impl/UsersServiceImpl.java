package com.baodanwang.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baodanwang.mapper.UsersMapper;
import com.baodanwang.pojo.Users;
import com.baodanwang.pojo.UsersExample;
import com.baodanwang.service.UsersService;

@Service("usersService")
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UsersMapper usersMapper = null;

	@Override
	public List<Users> getUserList(String sidx, String sord) throws Exception {
		UsersExample example = new UsersExample();
		example.setOrderByClause(sidx + " " + sord);
		List<Users> users = usersMapper.selectByExample(example);
		return users;
	}

	@Override
	public void deleteUser(String userId) throws Exception {
		usersMapper.deleteByPrimaryKey(userId);
	}

	@Override
	public List<Users> searchUser(String searchField, String searchString, String sidx, String sord) throws Exception {
		UsersExample example = new UsersExample();
		UsersExample.Criteria criteria = example.createCriteria();
		example.setOrderByClause(sidx + " " + sord);
		switch (searchField) {
		case "user_id":
			criteria.andUserIdLike("%" + searchString + "%");
			break;
		case "user_openid":
			criteria.andUserOpenidLike("%" + searchString + "%");
			break;
		case "user_nickName":
			criteria.andUserNicknameLike("%" + searchString + "%");
			break;
		case "user_weChatId":
			criteria.andUserWechatidLike("%" + searchString + "%");
			break;
		case "user_tel":
			criteria.andUserTelLike("%" + searchString + "%");
			break;
		case "user_address":
			criteria.andUserAddressLike("%" + searchString + "%");
			break;
		case "user_realName":
			criteria.andUserRealnameLike("%" + searchString + "%");
			break;
		case "user_addTime":
			criteria.andUserAddtimeLike("%" + searchString + "%");
			break;
		default:
			break;
		}
		List<Users> users = usersMapper.selectByExample(example);
		return users;
	}

	@Override
	public Users getUser(String userNickname, String userOpenid,String userAvatarurl) throws Exception {
		UsersExample example = new UsersExample();
		UsersExample.Criteria criteria = example.createCriteria();
		criteria.andUserOpenidEqualTo(userOpenid);
		List<Users> users = usersMapper.selectByExample(example);
		Users user = new Users();
		if (users.size() > 0) {
			user.setUserNickname(userNickname);
			user.setUserAvatarurl(userAvatarurl);
			usersMapper.updateByExample(user, example);
			List<Users> users1 = usersMapper.selectByExample(example);
			return users1.get(0);
		} else {
			UUID userId = UUID.randomUUID();
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String date1 = sdf.format(date);
			user.setUserId(String.valueOf(userId));
			user.setUserOpenid(userOpenid);
			user.setUserNickname(userNickname);
			user.setUserAvatarurl(userAvatarurl);
			user.setUserAddtime(date1);
			usersMapper.insert(user);
			List<Users> users1 = usersMapper.selectByExample(example);
			return users1.get(0);
		}
	}

}
