package com.example.moderadorscore;

import java.util.HashMap;
import java.util.Map;

public class ScoreModerator {
    private Map<String, Integer> pendingScores;
    private Map<String, Integer> finalScores;

    public ScoreModerator() {
        pendingScores = new HashMap<>();
        finalScores = new HashMap<>();
    }

    public void addPendingScore(String player, int score) {
        pendingScores.put(player, pendingScores.getOrDefault(player, 0) + score);
    }

    public void removePendingScore(String player) {
        pendingScores.remove(player);
    }

    public void approveAllScores() {
        for (Map.Entry<String, Integer> entry : pendingScores.entrySet()) {
            String player = entry.getKey();
            int pendingValue = entry.getValue();
            finalScores.put(player, finalScores.getOrDefault(player, 0) + pendingValue);
        }
        pendingScores.clear();
    }

    public String getFinalScoresAsString() {
        if (finalScores.isEmpty()) return "Nenhum score finalizado.";
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : finalScores.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }
}
