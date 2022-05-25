package lesson_1.main;


import lesson_1.obstacleCourse.Course;
import lesson_1.obstacleCourse.Cross;
import lesson_1.obstacleCourse.Fight;
import lesson_1.obstacleCourse.Swimming;
import lesson_1.team.Team;
import lesson_1.team.TeamMember;

public class Main {
    public static void main(String[] args) {
        Team rocketTeam = new Team("RocketTeam",
                new TeamMember("Bob", 10),
                new TeamMember("Nick",20),
                new TeamMember("Alex", 30),
                new TeamMember("Mike", 40));

        Course course = new Course(new Cross(7), new Swimming(15), new Fight(25));
        course.doIt(rocketTeam);

    }
}
