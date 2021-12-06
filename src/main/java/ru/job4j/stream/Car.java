package ru.job4j.stream;

/**
 * Класс описывает модель данных автомодиля.
 * с помощью шаблона проектирования Builder в  Stream.
 * @author Korotkiy Oleg
 * @version 1.0
 */
    public  class Car {
        /** поле название мадель автомобиля   */
        private String name;
        /** поле цвет автомобиля  */
        private String color;
        /** поле вид кузова  */
        private String vessel;
        /** поле год выпуска  */
        private int yearOfIssue;
        /** поле объем двигателя  */
        private double engineVolume;
        /** поле трансмиссия  */
        private String drivetrain;
        /** поле максимальная скорость  */
        private int topSpeed;

    @Override
    public String toString() {
        return "Car{"
                + "name='" + name + '\''
                + ", color='" + color + '\''
                + ", vessel='" + vessel + '\''
                + ", yearOfIssue=" + yearOfIssue
                + ", engineVolume=" + engineVolume
                + ", drivetrain='" + drivetrain + '\''
                + ", topSpeed=" + topSpeed
                + '}';
    }

    static class Bilder {
            private String name;
            private String color;
            private String vessel;
            private int yearOfIssue;
            private double engineVolume;
            private String drivetrain;
            private int topSpeed;

            Bilder bildName(String name) {
                this.name = name;
                return this;
            }

            Bilder bildColor(String color) {
                this.color = color;
                return this;
            }

            Bilder bildVessel(String vessel) {
                this.vessel = vessel;
                return this;
            }

            Bilder bildYearOfIssue(int yearOfIssue) {
                this.yearOfIssue = yearOfIssue;
                return this;
            }

            Bilder bildEngineVolume(double engineVolume) {
                this.engineVolume = engineVolume;
                return this;
            }

            Bilder bildDrivetrain(String drivetrain) {
                this.drivetrain = drivetrain;
                return this;
            }

            Bilder bildTopSpeed(int topSpeed) {
                this.topSpeed = topSpeed;
                return this;
            }

            Car bild() {
                Car car = new Car();
                car.name = name;
                car.color = color;
                car.vessel = vessel;
                car.yearOfIssue = yearOfIssue;
                car.engineVolume = engineVolume;
                car.drivetrain = drivetrain;
                car.topSpeed = topSpeed;
                return  car;
            }
        }

        public static void main(String[] args) {
            Car car = new Bilder().bildName("kia")
                    .bildColor("white")
                    .bildVessel("sidan")
                    .bildYearOfIssue(2020)
                    .bildEngineVolume(2.0)
                    .bildDrivetrain("mechanic")
                    .bildTopSpeed(190)
                    .bild();
            System.out.println(car);
        }
    }
