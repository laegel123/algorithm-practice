/*
https://school.programmers.co.kr/learn/courses/30/lessons/42579
*/
public class programmers42579 {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        Map<String, List<Song>> songMap = new HashMap<>();
        Map<String, Integer> rankMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            rankMap.put(genre, rankMap.getOrDefault(genre, 0) + play);
            
            songMap.putIfAbsent(genre, new ArrayList<>());
            songMap.get(genre).add(new Song(i, play));
        }
        
        List<String> genreList = new ArrayList<>(rankMap.keySet());
        genreList.sort((a, b) -> rankMap.get(b) - rankMap.get(a));
        
        List<Integer> result = new ArrayList<>();
        for (String genre : genreList) {
            List<Song> songList = songMap.get(genre);
            songList.sort((a, b) -> {
               if (b.play != a.play) {
                   return b.play - a.play;
               }
                return a.id - b.id;
            });
            
            int size = 0;
            for (Song song : songList) {
                if (size < 2) {
                    result.add(song.id);
                    size++;
                } else {
                    break;
                }
            }
        }
        
        answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}
