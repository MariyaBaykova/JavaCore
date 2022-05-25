package lesson_1.obstacleCourse;

import lesson_1.main.Status;
import lesson_1.team.Team;
import lesson_1.team.TeamMember;

public class Course {
    private Obstacle[] obstacles;

    public Course(Obstacle... obstacles) {
        this.obstacles = obstacles;
    }

    public void doIt(Team team) {
        for (TeamMember member: team.getMembers()) {
            for (Obstacle obs : obstacles) {
                obs.goChallenge(member);
                if (member.getStatus() == Status.NoPassedDistance) {
                    break;
                }
            }
        }
    }
}
