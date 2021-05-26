package day14;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

public interface UserMapper {

	
	public void save(User user);
	
	public User findBy(@Param("name") String name,@Param("sex") String sex);
	
	public User findById(@Param("id") int id);
	
	public User findByName(@Param("name") String name);
	
}
