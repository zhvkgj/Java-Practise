package Collections;

import java.util.*;
import java.util.function.Consumer;

public class MailInfrastructure {
    public static abstract class AbstractSendable<T> {
        private final String from;
        private final String to;
        private final T content;

        public AbstractSendable(String from, String to, T content) {
            this.from = from;
            this.to = to;
            this.content = content;
        }

        public String getFrom() {
            return from;
        }

        public String getTo() {
            return to;
        }

        public T getContent() {
            return content;
        }
    }

    public static class MailMessage extends AbstractSendable<String> {
        public MailMessage(String from, String to, String content) {
            super(from, to, content);
        }
    }

    public static class Salary extends AbstractSendable<Integer> {
        public Salary(String from, String to, Integer content) {
            super(from, to, content);
        }
    }

    public static class MailService<T> implements Consumer<AbstractSendable<T>> {
        private final Map<String, List<T>> mailBox = new HashMap<>() {
            @Override
            public List<T> get(Object key) {
                List<T> result = super.get(key);
                return result != null ? result : Collections.emptyList();
            }
        };

        public Map<String, List<T>> getMailBox() {
            return mailBox;
        }

        @Override
        public void accept(AbstractSendable<T> t) {
            String person = t.getTo();

            List<T> contents = getMailBox().get(person);
            if (contents.size() == 0){
                contents = new ArrayList<>();
            }
            contents.add(t.getContent());
            getMailBox().put(person, contents);
        }
    }
}
