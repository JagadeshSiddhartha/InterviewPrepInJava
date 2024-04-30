import kotlin.Pair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Third {

    static class CandidateVotes {
        int totalVotes = 0;
        ArrayList<Integer> votes;

        public  CandidateVotes(int totalVotes) {
            this.totalVotes = totalVotes;
            this.votes = new ArrayList<>(3);
        }
        public void updateVotes(int votes, int index, int count) {
            this.totalVotes += votes;
            this.votes.add(index, count);
        }
    }
    public static void main(String[] args) throws IOException {
        HashMap<Character, CandidateVotes> votes = new HashMap<>();
        String[] Ballots = {"ABC", "CD", "ABD"};
        for(String Ballot : Ballots) {
            for(int i = 0; i < Ballot.length(); i++) {
                Character presentCandidate = Ballot.charAt(i);
                if(votes.containsKey(presentCandidate)) {
                    CandidateVotes candidateVote = votes.get(presentCandidate);
                    candidateVote.updateVotes(3- i, i, 3 - i);
                    votes.put(presentCandidate, candidateVote);
                } else {
                    CandidateVotes candidateVote = new CandidateVotes(3 - i);
                    candidateVote.updateVotes(3- i, i, 3 - i);
                    votes.put(presentCandidate, candidateVote);
                }
            }
        }
        List<Pair<Character, CandidateVotes>> votesList = new ArrayList<>();

        for(Character candidate : votes.keySet()) {
            votesList.add(new Pair<>(candidate, votes.get(candidate) ));
        }
        votesList.sort(new Comparator<Pair<Character, CandidateVotes>>() {
            @Override
            public int compare(Pair<Character, CandidateVotes> o1, Pair<Character, CandidateVotes> o2) {
                if(o1.getSecond().totalVotes !=  o2.getSecond().totalVotes) {
                    return o2.getSecond().totalVotes - o1.getSecond().totalVotes;
                } else {
                    for (int i = 0; i < 3; i++) {
                        if(o1.getSecond().votes.get(i) !=  o2.getSecond().votes.get(i)) {
                            return o2.getSecond().votes.get(i) - o1.getSecond().votes.get(i);
                        }
                    }
                    return 1;
                }
            }
        });

        for(int i = 0; i < votesList.size(); i++) {
            System.out.println(votesList.get(i).getFirst());
        }

        int start = 0, end = 0;
        while(end < votesList.size()) {
            while(votesList.get(end).getSecond() == votesList.get(start).getSecond()) {
                end++;
            }

        }





    }
}


//    /**
//     * Process a list of ballots, and return all candidates sorted in descending order by their total number of points.
//     */
//    List<String> getResults(List<Ballot> ballots)
//
//
//        /*
//
//
//        A = 4
//        B = 4
//        C = 4
//
//         */