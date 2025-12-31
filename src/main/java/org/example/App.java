package org.example;

import org.example.motivation.controller.MotivationController;
import org.example.system.controller.SystemController;


public class App {
    public void run() {
        System.out.println("== 명언 앱 실행 ==");

        SystemController systemController = new SystemController();
        MotivationController motivationController = new MotivationController();

        while (true) {
            System.out.print("명령어");
            String cmd = Container.getSc().nextLine().trim();

            if (cmd.equals("exit")) {
                systemController.exit();
                break;
            } else if (cmd.length() == 0) {
                System.out.println("명령어 입력 안됨");
                continue;
            }

            if (cmd.equals("등록")) {
                motivationController.add();
            } else if (cmd.equals("목록")) {
                motivationController.list();
            } else if (cmd.startsWith("삭제")) {
                motivationController.del(cmd);
            } else if (cmd.startsWith("수정")) {
                motivationController.edit(cmd);
            } else {
                System.out.println("사용할 수 없는 명령어입니다");
            }

        }
    }
}