#include <stdio.h>

int main() {
    int obstacles, removes, speed;
    scanf("%d%d%d", &obstacles, &removes, &speed);
    /*
     * (1200 / speed) * (obstacles / removes + 1) + 2 * removes * (obstacles / removes) * (obstacles / removes + 1) / 2
     * (1200 / speed) * (obstacles / removes + 1) + obstacles * (obstacles / removes + 1)
     * (1200 / speed + obstacles) * (obstacles / removes + 1)
     */
    printf("%d\n", (1200 / speed + obstacles) * (obstacles / removes + 1));
}