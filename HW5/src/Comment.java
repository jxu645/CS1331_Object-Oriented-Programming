/**
 * Comment class.
 * @author Jessie Xu
 * @version 1.0
 */
public class Comment implements Likeable, Comparable<Comment> {
    private boolean isSpam;
    private int likes;
    private int dislikes;
    private String value;

    /**
     * Getter method of isSpam.
     * @return Returns isSpam
     */
    public boolean getIsSpam() {
        return this.isSpam;
    }

    /**
     * Setter method of isSpam.
     * @param isSpam New isSpam value passed in
     */
    public void setIsSpam(boolean isSpam) {
        this.isSpam = isSpam;
    }

    /**
     * Getter method of likes.
     * @return Returns likes
     */
    public int getLikes() {
        return this.likes;
    }

    /**
     * Setter method of likes.
     * @param likes New likes value passed in
     */
    public void setLikes(int likes) {
        if (likes >= 0) {
            this.likes = likes;
        }
    }

    /**
     * Getter method for dislikes.
     * @return Returns dislikes
     */
    public int getDislikes() {
        return this.dislikes;
    }

    /**
     * Setter method for dislikes.
     * @param dislikes New dislike value passed in
     */
    public void setDislikes(int dislikes) {
        if (dislikes >= 0) {
            this.dislikes = dislikes;
        }
    }

    /**
     * Getter method for value.
     * @return Returns value
     */
    public String getValue() {
        return this.value;
    }

    /**
     * Setter method for value.
     * @param value New value passed in
     */
    public void setValue(String value) {
        if (value != null) {
            this.value = value;
        }
    }

    /**
     * Constructor of Comment.
     * @param likes Value of likes passed in
     * @param dislikes Value of dislikes passed in
     * @param value Value of value passed in
     * @param isSpam Value of isSpam passed in
     */
    public Comment(int likes, int dislikes, String value, boolean isSpam) {
        if (likes >= 0) {
            this.likes = likes;
        } else {
            this.likes = 0;
        }
        if (dislikes >= 0) {
            this.dislikes = dislikes;
        } else {
            this.dislikes = 0;
        }
        if (value != null) {
            this.value = value;
        } else {
            this.value = "";
        }
        this.isSpam = isSpam;
    }

    /**
     * Override method of compareTo().
     */
    @Override
    public int compareTo(Comment o) {
        int thisLikeFactor = this.likes - this.dislikes;
        int paramLikeFactor = o.likes - o.dislikes;
        if (thisLikeFactor > paramLikeFactor) {
            return 1;
        } else if (thisLikeFactor < paramLikeFactor) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * Override method for toString.
     * @return Returns info of value, likes and if the comment is spam
     */
    @Override
    public String toString() {
        return this.value + ", " + this.likes + " likes, Spam: " + this.isSpam;
    }

    /**
     * Override method of equals.
     * @param o Object passed in to be compared
     * @return Returns is two comments are the same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null) {
            return false;
        } else if (!(o instanceof Comment)) {
            return false;
        } else {
            Comment param = (Comment) o;
            return this.getLikes() == param.getLikes()
                    && this.getDislikes() == param.getDislikes()
                    && this.getValue().equals(param.getValue())
                    && this.getIsSpam() == param.getIsSpam();
        }
    }
}