Set<Character> repeated = new HashSet<>();
List<Character> nonRepeated = new ArrayList<>();
for (int m = 0; m < wrd.length(); m++) {
            char l = wrd.charAt(m);
            if (repeated.contains(l)) {
                continue;
            }
            if (nonRepeated.contains(l)) {
                nonRepeated.remove((Character) l);
                repeated.add(l);
            } else {
                nonRepeated.add(l);
            }
        }
        return nonRepeated.get(0);
    }
