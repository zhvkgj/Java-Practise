package InputOutput;

import java.io.*;
import java.util.Objects;

public class SerializeAnimal {
    public static class Animal implements Serializable {
        private final String name;

        public Animal(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Animal) {
                return Objects.equals(name, ((Animal) obj).name);
            }
            return false;
        }
    }

    public static Animal[] deserializeAnimalArray(byte[] data) {
        int size;
        Animal[] deserializeAnimals;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(data))) {
            size = objectInputStream.readInt();

            deserializeAnimals = new Animal[size];
            for (int i = 0; i < size; i++) {
                deserializeAnimals[i] = (Animal) objectInputStream.readObject();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return deserializeAnimals;
    }
}
