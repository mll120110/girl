package com.vision.user;

import com.vision.girl.user.entity.BdRole;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)

public class UserRoleTest {

    @Test
    public void test() {
        Long userId = 1255048569881993217L;
        // 前端传的结果
        List<BdRole> beforeRoleList = new ArrayList<>();
        BdRole bdRole = new BdRole();
        bdRole.setRoleId(1255418158973308929L);
        bdRole.setRoleCode("string1");
        bdRole.setRoleName("string1");
        bdRole.setState(1);
        bdRole.setCreateTime(LocalDateTime.now());
        bdRole.setUpdateTime(LocalDateTime.now());
        beforeRoleList.add(bdRole);

        BdRole bdRole1 = new BdRole();
        bdRole1.setRoleId(1255418220021403649L);
        bdRole1.setRoleCode("string2");
        bdRole1.setRoleName("string2");
        bdRole1.setState(1);
        bdRole1.setCreateTime(LocalDateTime.now());
        bdRole1.setUpdateTime(LocalDateTime.now());
        beforeRoleList.add(bdRole1);
        // 数据库查询结果
        List<BdRole> bdRoleList = new ArrayList<>();
        BdRole bdRole2 = new BdRole();
        bdRole2.setRoleId(1255418220021403649L);
        bdRole2.setRoleCode("string2");
        bdRole2.setRoleName("string2");
        bdRole2.setState(0);
        bdRole2.setCreateTime(LocalDateTime.now());
        bdRole2.setUpdateTime(LocalDateTime.now());
        bdRoleList.add(bdRole2);
        // 1、新增场景：前端传A、B，后台查询当前用户绑定A、B无效、C有效，应该重新插入A、B（还可以更新A、B状态为有效）；
        // 前端传A、B，后台查询当前用户绑定C有效，应该插入A、B；
        // 前端传A、B，后台查询当前用户绑定A、B有效，无需操作
        List<BdRole> list = beforeRoleList.stream().filter(item -> !bdRoleList.stream().map(e -> e.hashCode())
            .collect(Collectors.toList()).contains(item.hashCode())).collect(Collectors.toList());
        System.out.println("list.toString() " + list.toString());
    }
}
