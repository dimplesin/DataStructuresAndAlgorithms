package com.company.Microsoft;

/**
 * Created by v-dsindhi on 8/1/15.
 */
public class CommonElementsInArray {
        public static void main (String[] args) {
            int[][] a = {
                    {10, 180, 200, 500, 500,},
                    {4, 150, 200, 170, 500,},
                    {2, 160, 200, 202, 203,},
                    {3, 150, 155, 200, 300},
                    {3, 150, 155, 200, 301}};

            int n = a.length;
            int[] x = new int[n];

            for (; x[0] < n; x[0]++) {
                int val = a[0][x[0]];
                boolean print = true;
                for (int i = 1; i < n; i++) {
                    while (a[i][x[i]] < val && x[i] < n - 1) x[i]++;
                    if (a[i][x[i]] != val) print = false;
                }
                if (print) System.out.println(val);
            }
        }
    }

    //Given 3 sorted arrays. Find the common element of all the arrays in O(N) time

    /*
#include <iostream>
#include <vector>

void findCommon(
    const std::vector<int>& v1,
    const std::vector<int>& v2,
    const std::vector<int>& v3,
    std::vector<int>* out) {
  // Make sure the output vector is empty.
  if (out == NULL) {
    return;
  } else {
    out->clear();
  }

  // Since v1, v2, and v3 are guaranteed to
  // be sorted, we'll just go through the motion
  // of 3-way merging the arrays, and record the
  // elements they have in common.
  int i1 = 0, i2 = 0, i3 = 0;
  while (i1 < v1.size() &&
          i2 < v2.size() &&
          i3 < v3.size()) {
    if (v1[i1] == v2[i2] && v1[i1] == v3[i3]) {
      out->push_back(v1[i1]);
      i1++;
      i2++;
      i3++;
    } else {
      if (v1[i1] <= v2[i2] && v1[i1] <= v3[i3]) {
        i1++;
      } else if (v2[i2] <= v3[i3]) {
        i2++;
      } else {
        i3++;
      }
    }
  }
}

int main()
{
  std::vector<int> v1 = { 0, 1, 2, 3, 4, 5, 6 };
  std::vector<int> v2 = { 2, 3, 6 };
  std::vector<int> v3 = { 3, 3 };
  std::vector<int> out;
  findCommon(v1, v2, v3, &out);
  std::cout << "Common elements:";
  for (int i = 0; i < out.size(); ++i) {
    std::cout << " " << out[i];
  }
  std::cout << std::endl;

  return 0;
}
     */
