package com.lzj.cloud.office.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lzj.cloud.office.model.RespBean;
import com.lzj.cloud.office.pojo.Admin;
import com.lzj.cloud.office.mapper.AdminMapper;
import com.lzj.cloud.office.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzj.cloud.office.utils.JwtTokenUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 老李
 * @since 2021-01-29
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Value("${jwt.tokenHead}")
    private String tokenHead;


    /**
     * 简易版用户登录
     * @param username
     * @param password
     * @return
     */
    @Override
    public RespBean login(String username, String password) {
        //登录
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if (null==userDetails){
            return RespBean.error("用户记录不存在!");
        }
        if (!passwordEncoder.matches(password,userDetails.getPassword())){
            return RespBean.error("用户密码错误!");
        }
        if (!userDetails.isEnabled()){
            return RespBean.error("账号被禁用，请联系管理员！");
        }
        //更新security登录用户对象
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails
                ,null,userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        //生成token
        String token = jwtTokenUtil.generateToken(userDetails);
        Map<String,String> tokenMap = new HashMap<>();
        tokenMap.put("token",token);
        tokenMap.put("tokenHead",tokenHead);
        return RespBean.success("登录成功",tokenMap);

    }

    @Override
    public Admin getAdminByUserName(String username) {
        return this.baseMapper.selectOne(new QueryWrapper<Admin>().eq("username",username));
    }
}
