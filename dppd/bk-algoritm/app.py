# def p_days(d_univercity):
#     if d_univercity <= 3:
#         print("it's good")
#     else:
#         print("it's bad")

# def p_bace(n_bace, l_mude):
#     if l_mude == 111:
#         if n_bace >= 0.8:
#             print(11)
#             return(11)
#         elif 0.8 > n_bace >= 0.5:
#             print(10)
#             return(10)
#         elif 0.5 > n_bace >= 0.3:
#             print(4)
#             return(4)
#         elif 0.3 > n_bace:
#             print(1)
#             return(1)
#         else:
#             print(0)
#             return(0)
#     elif l_mude == 100:
#         if n_bace >= 0.8:
#             print(11)
#             return(11)
#         elif 0.8 > n_bace >= 0.6:
#             print(10)
#             return(10)
#         elif 0.6 > n_bace >= 0.5:
#             print(8)
#             return(8)
#         elif 0.5 > n_bace >= 0.3:
#             print(4)
#             return(4)
#         elif 0.3 > n_bace:
#             print(1)
#             return(1)
#         else:
#             print(0)
#             return(0)
#     else:
#         print(000)
#         return(000)

# p_days()
# p_bace()

import ctypes

# بارگذاری کتابخانه‌ی اشتراکی
lib = ctypes.CDLL("./libapp.so")  # در ویندوز از './app.dll' استفاده کنید

# تعریف تابع bace
lib.bace.argtypes = [ctypes.c_int, ctypes.c_int, ctypes.c_int, ctypes.c_int]
lib.bace.restype = ctypes.c_float

# فراخوانی تابع bace از C++
n_bace = lib.bace(10, 20, 14, 20)  # ورودی‌های مثال: 10, 20, 14, 20
print(f"n_bace from C++: {n_bace}")

# حالا می‌توانید از n_bace در توابع پایتون استفاده کنید
def p_days(d_univercity):
    if d_univercity <= 3:
        print("it's good")
    else:
        print("it's bad")

def p_bace(n_bace, l_mude):
    if l_mude == 111:
        if n_bace >= 0.8:
            print(11)
            return 11
        elif 0.8 > n_bace >= 0.5:
            print(10)
            return 10
        elif 0.5 > n_bace >= 0.3:
            print(4)
            return 4
        elif 0.3 > n_bace:
            print(1)
            return 1
        else:
            print(0)
            return 0
    elif l_mude == 100:
        if n_bace >= 0.8:
            print(11)
            return 11
        elif 0.8 > n_bace >= 0.6:
            print(10)
            return 10
        elif 0.6 > n_bace >= 0.5:
            print(8)
            return 8
        elif 0.5 > n_bace >= 0.3:
            print(4)
            return 4
        elif 0.3 > n_bace:
            print(1)
            return 1
        else:
            print(0)
            return 0
    else:
        print(000)
        return 000

# مثال استفاده از توابع
p_days(2)  # مثال: ورودی ۲
p_bace(n_bace, 111)  # مثال: ورودی n_bace و ۱۱۱