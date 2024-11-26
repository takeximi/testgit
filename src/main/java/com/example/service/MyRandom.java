package com.example.service;

import java.util.Random;

public class MyRandom {
    private static final int MAX_LENGTH = 10;
    private static final int MAX_RANDOM_NUMBER = 99998; // Để đảm bảo chiều dài tối đa của mã là 10 ký tự

    public static String generateID() {
        Random random = new Random();
        int randomNumber = random.nextInt(MAX_RANDOM_NUMBER + 1); // Tạo số ngẫu nhiên trong khoảng 0 đến 99998

        // Chuyển đổi số ngẫu nhiên thành chuỗi, và kết hợp với PREFIX
        String id = "TC" + randomNumber;

        // Nếu mã dài hơn 10 ký tự, cần cắt bớt
        if (id.length() > MAX_LENGTH) {
            id = id.substring(0, MAX_LENGTH);
        }

        // Kiểm tra lại chiều dài và đảm bảo nhỏ hơn 10
        return id;
    }


}
