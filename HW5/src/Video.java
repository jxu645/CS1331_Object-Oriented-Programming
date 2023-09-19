import java.util.ArrayList;

/**
 * Class Video.
 * @author Jessie Xu
 * @version 1.0
 */
public class Video {
    private ArrayList<Comment> comments;
    private double length;
    private int likes;
    private int dislikes;

    /**
     * Getter method of comments.
     *
     * @return Returns comments
     */
    public ArrayList<Comment> getComments() {
        return this.comments;
    }

    /**
     * Setter method of comments.
     *
     * @param comments New comments value passed in to replace previous comments
     */
    public void setComments(ArrayList<Comment> comments) {
        if (comments != null) {
            this.comments = comments;
        }
    }

    /**
     * Getter method of length.
     *
     * @return Returns length
     */
    public double getLength() {
        return this.length;
    }

    /**
     * Setter method of length.
     *
     * @param length New length passed in
     */
    public void setLength(double length) {
        if (length >= 0 && length <= 60) {
            this.length = length;
        }
    }

    /**
     * Getter method for likes.
     *
     * @return Returns likes
     */
    public int getLikes() {
        return this.likes;
    }

    /**
     * Setter method for likes.
     *
     * @param likes New int likes passed in
     */
    public void setLikes(int likes) {
        if (likes > 0) {
            this.likes = likes;
        }
    }

    /**
     * Getter method for dislikes.
     *
     * @return Returns dislikes
     */
    public int getDislikes() {
        return this.dislikes;
    }

    /**
     * Setter method for dislikes.
     *
     * @param dislikes New int dislikes passed in
     */
    public void setDislikes(int dislikes) {
        if (dislikes > 0) {
            this.dislikes = dislikes;
        }
    }

    /**
     * Constructor of Video.
     *
     * @param length   Length of video
     * @param likes    Likes of video
     * @param dislikes Dislikes of video
     */
    public Video(double length, int likes, int dislikes) {
        if (length >= 0 && length <= 60) {
            this.length = length;
        } else {
            this.length = 0;
        }
        if (likes > 0) {
            this.likes = likes;
        } else {
            this.likes = 0;
        }
        if (dislikes > 0) {
            this.dislikes = dislikes;
        } else {
            this.dislikes = 0;
        }
        this.comments = new ArrayList<Comment>();
    }

    /**
     * Method that adds passed in comment value to arraylist.
     *
     * @param comment Comment to be added in arraylist comments
     */
    public void createComment(Comment comment) {
        this.comments.add(comment);
    }

    /**
     * Method that removes a comment value.
     *
     * @param comment Comment value passed in to be removed
     * @return Returns if the comment passed in was removed
     */
    public boolean removeComment(Comment comment) {
        return this.comments.remove(comment);
    }

    /**
     * Method that collects spam comments.
     *
     * @return Returns spam comments arraylist
     */
    public ArrayList<Comment> spamComments() {
        ArrayList<Comment> spamComments = new ArrayList<Comment>();
        for (int i = 0; i < this.comments.size(); i++) {
            if (this.comments.get(i).getIsSpam()) {
                spamComments.add(this.comments.get(i));
            }
        }
        return spamComments;
    }

    /**
     * Converts comments to an array.
     *
     * @return Returns the converted array
     */
    public Comment[] toArray() {
        Comment[] arr = new Comment[this.comments.size()];
        for (int i = 0; i < this.comments.size(); i++) {
            arr[i] = this.comments.get(i);
        }
        return arr;
    }

    /**
     * Method that represents top and worst comment.
     *
     * @return Returns array with top and worst comment
     */
    public Comment[] topAndWorstComment() {
        Comment topComment = null;
        Comment worstComment = null;
        Comment[] topAndWorst;
        if (this.comments.size() == 1) {
            topAndWorst = new Comment[] {this.comments.get(0), this.comments.get(0)};
            return topAndWorst;
        } else {
            for (int i = 0; i < this.comments.size(); i++) {
                if (topComment == null || this.comments.get(i).compareTo(topComment) > 0) {
                    topComment = this.comments.get(i);
                }
                if (worstComment == null || this.comments.get(i).compareTo(worstComment) < 0) {
                    worstComment = this.comments.get(i);
                }
            }
            topAndWorst = new Comment[]{topComment, worstComment};
            return topAndWorst;
        }
    }

    /**
     * Overriding method of toString.
     *
     * @return Returns info of Video
     */
    @Override
    public String toString() {
        return "This video has " + this.comments.size() + " comments and is " + this.length + " long.";
    }

    /**
     * Overriding equals method.
     *
     * @param o Object passed in
     * @return Returns if two videos are equal to each other
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null) {
            return false;
        } else if (!(o instanceof Video)) {
            return false;
        } else {
            Video param = (Video) o;
            return this.comments.size() == param.comments.size()
                    && this.getLength() == param.getLength()
                    && this.getLikes() == param.getLikes()
                    && this.getDislikes() == param.getDislikes();
        }
    }
}