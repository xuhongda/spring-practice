package com.xu.combootcomponnent.mapper;

import com.xu.combootcomponnent.entity.UserEntity;
import com.xu.combootcomponnent.enums.UserSexEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

	@Autowired
	private com.xu.combootcomponnent.mapper.mysql1Mapper.UserMapper UserMapper;

	@Test
	public void testInsert() throws Exception {
		for (int i =0;i<100;i++){
			UserMapper.insert(new UserEntity("aa", "a123456", UserSexEnum.MAN));
			UserMapper.insert(new UserEntity("bb", "b123456", UserSexEnum.WOMAN));
			UserMapper.insert(new UserEntity("cc", "b123456", UserSexEnum.WOMAN));
		}


		//Assert.assertEquals(3, UserMapper.getAll().size());
	}

	@Test
	public void testQuery() throws Exception {
		List<UserEntity> users = UserMapper.getAll();
		if(users==null || users.size()==0){
			System.out.println("is null");
		}else{
			System.out.println(users.toString());
		}
	}
	
	
	@Test
	public void testUpdate() throws Exception {
		UserEntity user = UserMapper.getOne(28L);
		System.out.println(user.toString());
		user.setNickName("neo");
		UserMapper.update(user);
		Assert.assertTrue(("neo".equals(UserMapper.getOne(6l).getNickName())));
	}

}