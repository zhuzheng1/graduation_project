package com.zt.kehuduan.service;

import com.zt.kehuduan.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Component
public interface UserService {
    String login(String user_name, String password);

    boolean register(User user);

    Map<String, String> us(String user_id);

    boolean changeHeadPortrait(MultipartFile file, String user_id) throws IOException, InterruptedException;

    boolean changeQQ(String newQQ, String user_id);

    boolean changePhone(String newPhone, String user_id);

    boolean addCollect(String goods_id, String user_id);

    boolean deleteCollect(String goods_id, String user_id);

    boolean deleteCollect(String goods_id);

    String getImage(String user_id);
}
