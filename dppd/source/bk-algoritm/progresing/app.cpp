#include <iostream>
#include "app.h"
#include <iomanip>

// void dariaft(int &a, int &b, int &c, int &d) {
//     std::cout << ("enter for int : ");
//     std::cin >> a >> b >> c >> d;
// }

// float bace(int ls_hours, int l_units, int d_tasks, int c_units){
//     float l_bace = static_cast<float>(ls_hours) / l_units;
//     float free_t = (16 - d_tasks) / 2.0f;
//     int ns_hours = free_t + ((ls_hours * l_bace) * 3);
//     float n_bace = ns_hours / c_units;
//     return (n_bace);
// }

// int main() {
//     int a, b, c, d;
//     float n_bace;
//     std::cout << ("enter for int : ");
//     std::cin >> a >> b >> c >> d;
//     n_bace = bace(a, b, c, d);
//     std::cout << std::fixed << std::setprecision(1) << n_bace << std::endl;
//     return 0;
// }
extern "C" {
    float bace(int ls_hours, int l_units, int d_tasks, int c_units) {
        float l_bace = static_cast<float>(ls_hours) / l_units;
        float free_t = (16 - d_tasks) / 2.0f;
        float ns_hours = free_t + ((ls_hours * l_bace) * 3);
        float n_bace = ns_hours / c_units;
        return n_bace;
    }
}

// float bace(int ls_hours, int l_units, int d_tasks, int c_units) {
//     float l_bace = static_cast<float>(ls_hours) / l_units; // محاسبه l_bace
//     float free_t = (16 - d_tasks) / 2.0f; // محاسبه free_t
//     float ns_hours = free_t + ((ls_hours * l_bace) * 3); // محاسبه ns_hours
//     float n_bace = ns_hours / c_units; // محاسبه n_bace
//     return n_bace;
// }

int main() {
    int a, b, c, d;
    float n_bace;
    std::cout << "enter for int (ls_hours, l_units, d_tasks, c_units): ";
    std::cin >> a >> b >> c >> d;
    n_bace = bace(a, b, c, d);
    std::cout << std::fixed << std::setprecision(1) << n_bace << std::endl; // نمایش با یک رقم اعشار
    return 0;
}
