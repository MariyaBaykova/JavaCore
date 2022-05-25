package lesson_1.team;

import lesson_1.main.Status;

public class TeamMember {

    private Status status = Status.NoPassedDistance;
    private final String name;
    private final int power;

    public TeamMember(String name, int power) {
        this.name = name;
        this.power = power;
    }

    public Status getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public void fight(int courseDifficulty) {
        if (checkPower(courseDifficulty)) {
            changeStatus(Status.PassedDistance, " победил в бою");
        } else {
            changeStatus(Status.NoPassedDistance, " проиграл в бою");
        }
    }

    public void jump(int courseDifficulty) {
        if (checkPower(courseDifficulty)) {
            changeStatus(Status.PassedDistance, " преодолел барьер");
        } else {
            changeStatus(Status.NoPassedDistance, " не преодолел барьер");
        }
    }

    public void run(int courseDifficulty) {
        if (checkPower(courseDifficulty)) {
            changeStatus(Status.PassedDistance, " пробежал кросс");
        } else {
            changeStatus(Status.NoPassedDistance, " не пробежал кросс");
        }
    }

    public void swim(int courseDifficulty) {
        if (checkPower(courseDifficulty)) {
            changeStatus(Status.PassedDistance, " проплыл дистанцию");
        } else {
            changeStatus(Status.NoPassedDistance, " не проплыл дистанцию");
        }
    }

    private boolean checkPower(int courseDifficulty) {
        return power > courseDifficulty || power == courseDifficulty;
    }

    private void changeStatus(Status newStatus, String message) {
        status = newStatus;
        System.out.println(name + message);
    }


}
