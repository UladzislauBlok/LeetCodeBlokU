package org.ubdev.task.math.easy;

class TypeTriangle {

    private static final String EQUILATERAL = "equilateral";
    private static final String ISOSCELES = "isosceles";
    private static final String SCALENE = "scalene";
    private static final String NONE = "none";

    public String triangleType(int[] nums) {
        if (nums[0] == nums[1] && nums[1] == nums[2])
            return EQUILATERAL;
        if (nums[0] + nums[1] <= nums[2] || nums[1] + nums[2] <= nums[0] || nums[0] + nums[2] <= nums[1])
            return NONE;
        if (nums[0] == nums[1] || nums[1] == nums[2] || nums[0] == nums[2])
            return ISOSCELES;
        return SCALENE;
    }
}
