import java.util.ArrayList;
import java.util.List;


public class Feedback<T> {
    private List<T> feedbackList;


//    Constructor for feedback
    public Feedback() {
        this.feedbackList = new ArrayList<>();
    }

    // Adding feedback to the list
    public void addFeedback(T rev) {
        feedbackList.add(rev);
    }

    // Getter for feedbacks
    public List<T> getFeedbackList() {
        return feedbackList;
    }

    // Printing all the feedbacks
    public void displayFeedback() {
        if (feedbackList.isEmpty()) {
            System.out.println("No feedback given.");
        }
        else {
            for (int i=0; i<feedbackList.size(); i++) {
                System.out.println(feedbackList.get(i));
            }
        }
    }
}
