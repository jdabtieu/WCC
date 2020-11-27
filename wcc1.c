#include <stdio.h>

int main() {
    char input[11] = {0}; scanf("%s", &input[0]);
    if ((input[0] == '8' && input[1] == '0' && input[2] == '0') ||
        (input[0] == '9' && input[1] == '0' && input[2] == '9') ||
        (input[6] == input[9] && input[7] == input[8]) ||
        (input[3] == input[4] && input[4] == input[5])) {
            printf("yes\n");
            return 0;
        }
    printf("no\n");
    return 0;
}