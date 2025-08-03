package org.ubdev.task.heap.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class MeetingRoomsIII {

    public int mostBooked(int n, int[][] meetings) {
        Map<Integer, Integer> roomsUse = new HashMap<>();
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]); // why they are not sorted :)
        PriorityQueue<Integer> roomsFree = new PriorityQueue<>();
        PriorityQueue<Pair> meets = new PriorityQueue<>((a,b) -> a.end - b.end == 0 ? a.room - b.room : a.end - b.end);
        for (int i = 0; i < n; i++) {
            roomsFree.add(i);
            roomsUse.put(i, 0);
        }
        for (int[] meet : meetings) {
            while (!meets.isEmpty() && meet[0] >= meets.peek().end) {
                roomsFree.add(meets.poll().room);
            }
            int start = meet[0];
            if (roomsFree.isEmpty()) {
                Pair lastMeet = meets.poll();
                roomsFree.add(lastMeet.room);
                start = lastMeet.end;
            }
            int duration = meet[1] - meet[0];
            int nextRoom = roomsFree.poll();
            meets.add(new Pair(nextRoom, start + duration));
            roomsUse.put(nextRoom, roomsUse.get(nextRoom) + 1);
        }
        int max = Integer.MIN_VALUE;
        int res = -1;
        for (Map.Entry<Integer, Integer> entry : roomsUse.entrySet()) {
            if (max < entry.getValue()) {
                max = entry.getValue();
                res = entry.getKey();
            }
        }
        return res;
    }

    private record Pair(int room, int end){}
}
