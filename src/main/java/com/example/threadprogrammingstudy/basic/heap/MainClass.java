package com.example.threadprogrammingstudy.basic.heap;

/*
    [Stack 영역]
    args = null 저장
    x = 10 저장
    x = 20 저장
    myDTO 주소값 저장 (MyDTO 객채 자체는 Heap 에 저장 : MyDTO.getSum = 0)
    (Heap 영역에 저장된 객채의 필드값 변경 MyDTO.getSum = 30)
    result = 30 저장
        Stack 영역 데이터 삭제 LIFO (Last In First Out)
        GC 가 MyDTO 객체 자체를 제거
 */
public class MainClass {

    public static void main(String[] args) {
        int x = 10;
        int y = 20;
        MyDTO myDTO = new MyDTO();
        myDTO.setSum(x+y);
        int result = myDTO.getSum();
        System.out.println(result);
    }
}
