package com.company.amazon.ProgramsDoneSoFar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by v-dsindhi on 6/23/15.
 */
final class Station {
        private final int stationTime;
        private final int transtionToTime; // time to transition`to` this station
        private final int transitionFromTime; // time to transitition `from` this station.
        public Station(int stationTime, int transitionTime, int transitionFromTime) {
            this.stationTime = stationTime;
            this.transtionToTime = transitionTime;
            this.transitionFromTime = transitionFromTime;
        }
        public int getStationTime() {
            return stationTime;
        }
        public int getTransitionToTime() {
            return transtionToTime;
        }
        public int getTransitionFromTime() {
            return transitionFromTime;
        }
    }

    final class AssemblyLineScheduling {
        private AssemblyLineScheduling() {}
        /**
         * Given an assembly line, outputs the shortest time needed to go through it.
         * The input data structures are not expected to be changed by client.
         *
         * @param line1     the assembly line 1
         * @param line2     the assumbly line 2
         * @return          the minumum time needed to process the item.
         */
        public static int assemblyLineShortestTime(List<Station> line1, List<Station> line2) {
            int prevLine1Min = line1.get(0).getStationTime() + line1.get(0).getTransitionToTime();
            int prevLine2Min = line2.get(0).getStationTime() + line2.get(0).getTransitionToTime();
            for (int i = 1; i < line1.size(); i++) {
                int currentLine1Min = line1.get(i).getStationTime() +
                                        Math.min(prevLine1Min, prevLine2Min + line1.get(i).getTransitionToTime());
                int currentLine2Min = line2.get(i).getStationTime() +
                                        Math.min(prevLine1Min + line2.get(i).getTransitionToTime(), prevLine2Min);
                prevLine1Min = currentLine1Min;
                prevLine2Min = currentLine2Min;
            }
            return Math.min(prevLine1Min + line1.get(line1.size() - 1).getTransitionFromTime(),
                    prevLine2Min + line2.get(line2.size() - 1).getTransitionFromTime());
        }

        public static void main(String[] args) {
            List<Station> line1 = new ArrayList<Station>();
            line1.add(new Station(4, 10, 7));
            line1.add(new Station(5,  9, 4));
            line1.add(new Station(3,  2, 5));
            line1.add(new Station(2,  8, 18));
            List<Station> line2 = new ArrayList<Station>();
            line2.add(new Station( 2, 12, 9));
            line2.add(new Station(10,  7, 2));
            line2.add(new Station( 1,  4, 8));
            line2.add(new Station( 4,  5, 7));
            System.out.println(assemblyLineShortestTime(line1, line2));
        }
    }

