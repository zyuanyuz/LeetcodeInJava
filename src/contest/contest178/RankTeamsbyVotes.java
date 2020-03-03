package contest.contest178;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * leetcode 1366
 */
public class RankTeamsbyVotes {

    public String rankTeamsTmp(String[] votes) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < votes.length; i++) {
            int length = votes[i].length();
            for (int j = 0; j < length; j++) {
                char c = votes[i].charAt(j);
                if (!map.containsKey(c)) {
                    map.put(c, length - j);
                } else {
                    map.put(c, map.get(c) + length - j);
                }
            }
        }

        StringBuilder strBuilder = new StringBuilder();
        Set<Character> set = new HashSet<>();
        while (set.size() < map.keySet().size()) {
            int maxValue = 0;
            char rankC = 'A' - 1;
            for (Character c : map.keySet()) {
                if (!set.contains(c) && (map.get(c) > maxValue || (map.get(c) == maxValue && c < rankC))) {
                    rankC = c;
                    maxValue = map.get(c);
                }
            }
            if (maxValue > 0) {
                strBuilder.append(String.valueOf(rankC));
                set.add(rankC);
            }
        }

        return strBuilder.toString();
    }

    public String rankTeams(String[] votes) {
        

        return null;
    }

    public static void main(String[] args) {
        RankTeamsbyVotes r = new RankTeamsbyVotes();
        System.out.println(r.rankTeams(new String[] { "FVSHJIEMNGYPTQOURLWCZKAX", "AITFQORCEHPVJMXGKSLNZWUY",
                "OTERVXFZUMHNIYSCQAWGPKJL", "VMSERIJYLZNWCPQTOKFUHAXG", "VNHOZWKQCEFYPSGLAMXJIUTR",
                "ANPHQIJMXCWOSKTYGULFVERZ", "RFYUXJEWCKQOMGATHZVILNSP", "SCPYUMQJTVEXKRNLIOWGHAFZ",
                "VIKTSJCEYQGLOMPZWAHFXURN", "SVJICLXKHQZTFWNPYRGMEUAO", "JRCTHYKIGSXPOZLUQAVNEWFM",
                "NGMSWJITREHFZVQCUKXYAPOL", "WUXJOQKGNSYLHEZAFIPMRCVT", "PKYQIOLXFCRGHZNAMJVUTWES",
                "FERSGNMJVZXWAYLIKCPUQHTO", "HPLRIUQMTSGYJVAXWNOCZEKF", "JUVWPTEGCOFYSKXNRMHQALIZ",
                "MWPIAZCNSLEYRTHFKQXUOVGJ", "EZXLUNFVCMORSIWKTYHJAQPG", "HRQNLTKJFIEGMCSXAZPYOVUW",
                "LOHXVYGWRIJMCPSQENUAKTZF", "XKUTWPRGHOAQFLVYMJSNEIZC", "WTCRQMVKPHOSLGAXZUEFYNJI" }));
    }
}