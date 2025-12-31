package org.example.motivation.controller;

import org.example.Container;
import org.example.motivation.entity.Motivation;

import java.util.ArrayList;
import java.util.List;

public class MotivationController {

    int lastId = 0;
    List<Motivation> motivations = new ArrayList<Motivation>();

    public void add() {
        int id = lastId + 1;
        System.out.print("작가:");
        String body = Container.getSc().nextLine().trim();

        System.out.print("명언:");
        String source = Container.getSc().nextLine().trim();

        Motivation motivation = new Motivation(id, body, source);
        motivations.add(motivation);

        System.out.printf("%d번 명언이 등록되었습니다.\n", id);
        lastId++;
    }

    public void list() {
        System.out.println("=".repeat(40));
        System.out.printf("번호   /   명언   /   작가   \n");

        if (motivations.size() == 0) {
            System.out.println("등록된 명언이 없습니다");
            return;
        }

        for (int i = motivations.size() - 1; i >= 0; i--) {
            Motivation motivation = motivations.get(i);
            System.out.printf("   %d     /    %s     /    %s   \n", motivation.getId(), motivation.getSource(), motivation.getBody());
        }
        System.out.println("=".repeat(40));
    }


    public void del(String cmd) {
        String[] cmdBits = cmd.split(" ");
        int id = Integer.parseInt(cmdBits[1]);

        if (cmdBits.length == 1) {
            System.out.println("명령어 다시 확인해주세요.");
            return;
        }
        Motivation foundMotivation = findById(id);

        if (foundMotivation == null) {
            System.out.println(id + " 번 명언은 존재하지 않습니다.");
            return;
        }

        motivations.remove(foundMotivation);
        System.out.println(id + "번 명언이 삭제되었습니다.");
    }


    public void edit(String cmd) {
        String[] cmdBits = cmd.split(" ");
        int id = Integer.parseInt(cmdBits[1]);

        if (cmdBits.length == 1) {
            System.out.println("명령어를 확인해주세요");
            return;
        }
        Motivation foundMotivation = findById(id);

        if (foundMotivation == null) {
            System.out.println(id + "번 명언이 없습니다");
            return;
        }

        System.out.println("작가 : " + foundMotivation.getBody());
        System.out.println("명언 : " + foundMotivation.getSource());

        String newBody;
        String newSource;
        while (true) {
            System.out.print("작가 : ");
            newBody = Container.getSc().nextLine().trim();

            if (newBody.length() != 0) {
                break;
            }

            System.out.println("작가 수정사항 입력해주세요");
        }
        while (true) {
            System.out.print("명언 : ");
            newSource = Container.getSc().nextLine().trim();

            if (newSource.length() != 0) {
                break;
            }

            System.out.println(" 명언 수정사항 입력해주세요");
        }


        foundMotivation.setBody(newBody);
        foundMotivation.setSource(newSource);

        System.out.println(id + "번 명언이 수정되었습니다");
    }

    public void detail(String cmd) {
        String[] cmdBits = cmd.split(" ");
        int id = Integer.parseInt(cmdBits[1]);

        if (cmdBits.length == 1) {
            System.out.println("명령어를 확인해주세요");
            return;
        }

        Motivation foundMotivation = findById(id);

        if (foundMotivation == null) {
            System.out.println("해당 명언은 존재하지 않습니다");
            return;
        }
        System.out.println("===== 상세보기 =====");
        System.out.println("번호 :" + foundMotivation.getId());
        System.out.println("작가 : " + foundMotivation.getBody());
        System.out.println("명언 : " + foundMotivation.getSource());

    }


    private Motivation findById(int id) {
        for (Motivation motivation : motivations) {
            if (motivation.getId() == id) {
                return motivation;
            }
        }
        return null;
    }
}
