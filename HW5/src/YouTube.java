import java.util.ArrayList;

/**
 * Driver class YouTube.
 * @author Jessie Xu
 * @version 1.0
 */
public class YouTube {
    /**
     * Main method.
     * @param args Arguments passed in
     */
    public static void main(String[] args) {
        Video video1 = new Video(20, 50, 10);
        Video video2 = new Video(30, 60, 15);
        Comment comment1 = new Comment(10, 2, "This is a spam comment", true);
        Comment comment2 = new Comment(10, 5, "This is not a spam comment", false);
        //Test createComment
        video1.createComment(comment1);
        video1.createComment(comment1);
        video1.createComment(comment2);
        video2.createComment(comment1);
        //Test removeComment
        System.out.println("Remove comment1 from video1: " + video1.removeComment(comment1));
        //Test spamComments
        ArrayList<Comment> spamComments = video1.spamComments();
        System.out.println("Video1 spamComments(): ");
        for (int i = 0; i < spamComments.size(); i++) {
            System.out.println(spamComments.get(i));
        }
        //Test toArray
        Comment[] video1CommentsArray = video1.toArray();
        System.out.println("Video 1 comments toArray(): ");
        for (int i = 0; i < video1CommentsArray.length; i++) {
            System.out.println(video1CommentsArray[i]);
        }
        //Test topAndWorstComment
        Comment[] topAndWorstComment = video1.topAndWorstComment();
        System.out.println("Top Comment of Video1: " + topAndWorstComment[0]);
        System.out.println("Worst Comment of Video1: " + topAndWorstComment[1]);
        //Test toString
        System.out.println("Info of video1: " + video1.toString());
        System.out.println("Info of video2: " + video2.toString());
        //Test equals
        System.out.println("Video1 vs. Video2 equals(): " + video1.equals(video2));
    }
}