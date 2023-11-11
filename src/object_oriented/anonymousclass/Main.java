package object_oriented.anonymousclass;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {
        // 일반적인 클래스 사용
        Button button = new Button("start");
        button.addActionListener(new EventHandler());


        // 익명클래스 사용 -> 객체 생성과 함께 필요 메서드를 구현하여 한번만 사용 
        Button anonymousButton = new Button("start");
        anonymousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ActionEvent occurred!");
            }
        });
    }

    static class EventHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("ActionEvent occurred!");
        }
    }
}
