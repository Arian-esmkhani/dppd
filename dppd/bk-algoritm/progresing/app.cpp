#include <iostream>
#include <iomanip>


//تابعی که اطلاعات کاربر راگرفته و توانایی مطلعاتی جدید آن را برای پایتون بر می گرداند 
extern "C" {
    float bace(int ls_hours, int l_units, int d_tasks, int c_units) {
        float l_bace = static_cast<float>(ls_hours) / l_units;
        float free_t = (16 - d_tasks) / 2.0f;
        float ns_hours = free_t + ((ls_hours * l_bace) * 3);
        float n_bace = ns_hours / c_units;
        return n_bace;
    }
}

int main() {
    float ls_hours, l_units, d_tasks, c_units;
    float n_bace;
    std::cout << "enter for int (ls_hours, l_units, d_tasks, c_units): ";
    //دریافت متغیر ها از دیتا بیس
    std::cin >> ls_hours >> l_units >> d_tasks >> c_units;
    n_bace = bace(ls_hours, l_units, d_tasks, c_units);
    std::cout << std::fixed << std::setprecision(1) << n_bace << std::endl; // نمایش با یک رقم اعشار
    return 0;
}
