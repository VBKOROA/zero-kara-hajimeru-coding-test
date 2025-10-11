package cote.study.simulationQ02;

import java.util.PriorityQueue;

public class Solution {
    record Report(int 접수시간, int 소요시간) implements Comparable<Report> {
        @Override
        public int compareTo(Report other) {
            return this.접수시간 - other.접수시간;
        }

        public static Report of(int[] report) {
            return new Report(report[0], report[1]);
        }
    }

    record Process(int 완료시간) implements Comparable<Process> {
        public static Process from(Report r) {
            return new Process(r.접수시간 + r.소요시간);
        }

        public static Process from(Report r, int currentTime) {
            return new Process(currentTime + r.소요시간);
        }

        @Override
        public int compareTo(Process other) {
            return this.완료시간 - other.완료시간;
        }
    }

    public int solution(int moderator_count, int[][] reports) {
        PriorityQueue<Report> reportQueue = new PriorityQueue<>();
        PriorityQueue<Process> moderatorQueue = new PriorityQueue<>();

        for (int[] report : reports) {
            reportQueue.offer(Report.of(report));
        }

        moderatorQueue.offer(Process.from(reportQueue.poll()));

        int max완료시간 = 0;
        
        while(!reportQueue.isEmpty()) {
            // 완료 후 접수 혹은 접수
            boolean isModeratorTaskCompleted = moderatorQueue.peek().완료시간 <= reportQueue.peek().접수시간;
            boolean isModeratorQueueFull = moderatorQueue.size() == moderator_count;
            Process 접수할Process;

            if(isModeratorTaskCompleted || isModeratorQueueFull) {
                Process finished = moderatorQueue.poll();
                Report report = reportQueue.poll();
                접수할Process = Process.from(report, Math.max(finished.완료시간, report.접수시간));
                moderatorQueue.offer(접수할Process);
            } else {
                접수할Process = Process.from(reportQueue.poll());
                moderatorQueue.offer(접수할Process);
            }

            max완료시간 = Math.max(접수할Process.완료시간, max완료시간);
        }

        return max완료시간;
    }
}
