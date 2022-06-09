package com.programmers;




import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BestAlbum {
    public static void main(String[] args){
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        int[] result = solution(genres, plays);
        System.out.println(Arrays.toString(result));
    }
    static class Song implements Comparable<Song>{
        String genre;
        int index;
        int plays;

        public Song(String genre, int idx, int plays){
            this.genre = genre;
            this.index= idx;
            this.plays = plays;
        }

        public String getGenre(){
            return genre;
        }

        @Override
        public int compareTo(Song o) {
            if(this.plays == o.plays ) return this.index - o.index;
            else return o.plays - this.plays;
        }
    }
    public static int[] solution(String[] genres, int[] plays) {
//        List<Integer> answer = new ArrayList<>();
//        Map<String, Integer> dGenre = new HashMap<>();
//        Map<String, PriorityQueue<Song>> album = new HashMap<>();
//        for(int i=0; i < genres.length;i++){
//            PriorityQueue<Song> song = new PriorityQueue<>();
//            if(album.containsKey(genres[i])){
//                song.addAll(album.get(genres[i]));
//            }
//            song.offer(new Song(genres[i], i, plays[i]));
//            album.put(genres[i], song);
//
//        }
//
//        for(String key : album.keySet()){
//            PriorityQueue<Song> que = album.get(key);
//            int idx = 0;
//            while(idx < 2 && !que.isEmpty()){
//                answer.add(que.poll().index);
//                idx++;
//            }
//        }
//        return answer.stream().mapToInt(Integer::intValue).toArray();
        return IntStream.range(0, genres.length)
                .mapToObj(i -> new Song(genres[i], i, plays[i]))
                .collect(Collectors.groupingBy(Song::getGenre))
                .entrySet().stream()
                .sorted((a,b) -> sum(b.getValue()) - sum(a.getValue()))
                .flatMap(x -> x.getValue().stream().sorted().limit(2))
                .mapToInt(x -> x.index).toArray();
    }
    private static int sum(List<Song> value) {
        int answer = 0;
        for (Song song : value) {
            answer+=song.plays;
        }
        return answer;
    }
}
