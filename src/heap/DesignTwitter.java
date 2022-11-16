package heap;

import java.util.*;

public class DesignTwitter {
    static class Twitter {
        class User {
            int uId;
            List<int[]> tweets;
            Set<Integer> follows;

            User(int uId, List<int[]> tweets, Set<Integer> follows) {
                this.uId = uId;
                this.tweets = tweets;
                this.follows = follows;
            }
        }

        class Tweet {
            int uId;
            int i;
            int ts;
            int tid;

            Tweet(int uId, int i, int ts, int tid) {
                this.uId = uId;
                this.i = i;
                this.ts = ts;
                this.tid = tid;
            }
        }

        List<User> users;

        static int t = 0;

        public Twitter() {
            users = new ArrayList<>();

            for (int i = 0; i <= 500; i++) {
                users.add(new User(i, new ArrayList<>(), new HashSet<>()));
            }

            users.set(0, null);
        }

        public void postTweet(int userId, int tweetId) {
            User cur = users.get(userId);

            if (!cur.follows.contains(userId)) {
                cur.follows.add(userId);
            }

            cur.tweets.add(new int[]{t++, tweetId});
        }

        public List<Integer> getNewsFeed(int userId) {
            User cur = users.get(userId);

            int k = 10;

            PriorityQueue<Tweet> pq = new PriorityQueue<>((t1, t2) -> t2.ts - t1.ts);

            for (int u : cur.follows) {
                User f = users.get(u);
                List<int[]> tw = f.tweets;
                int last = tw.size();

                if (last > 0) {
                    int[] r = tw.get(last - 1);
                    pq.add(new Tweet(u, last - 1, r[0], r[1]));
                }
            }

            List<Integer> news = new ArrayList<>();

            while (k > 0 && !pq.isEmpty()) {
                Tweet t = pq.poll();
                int uId = t.uId;
                int index = t.i;

                news.add(t.tid);

                User f = users.get(uId);
                List<int[]> tw = f.tweets;

                if (index > 0) {
                    int r[] = tw.get(index - 1);
                    pq.add(new Tweet(uId, index - 1, r[0], r[1]));
                }

                k--;
            }

            return news;
        }

        public void follow(int followerId, int followeeId) {
            User cur = users.get(followerId);

            if (!cur.follows.contains(followerId)) {
                cur.follows.add(followerId);
            }

            cur.follows.add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            User cur = users.get(followerId);

            cur.follows.remove(followeeId);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        Twitter obj = new Twitter();
        int userId = sc.nextInt();
        int tweetId = sc.nextInt();

        obj.postTweet(userId, tweetId);
        List<Integer> param_2 = obj.getNewsFeed(userId);

        int followerId = sc.nextInt();
        int followeeId = sc.nextInt();

        obj.follow(followerId, followeeId);
        obj.unfollow(followerId, followeeId);
    }
}
