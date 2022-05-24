package Main;

import obstacleCourse.Course;
import obstacleCourse.Cross;
import obstacleCourse.Fight;
import obstacleCourse.Swimming;
import team.Team;
import team.TeamMember;

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
