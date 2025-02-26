import ctypes


lib = ctypes.CDLL("./libapp.so")  


lib.bace.argtypes = [ctypes.c_int, ctypes.c_int, ctypes.c_int, ctypes.c_int]
lib.bace.restype = ctypes.c_float


n_bace = lib.bace(10, 20, 14, 20)  
print(f"n_bace from C++: {n_bace}")

# کد های بالا برای دریافت اطلاعات از سی پلاس پلاس است

def p_days(d_univercity):
    if d_univercity <= 3:
        return "it's good"
    else:
        return "it's bad"

#این تابه برای برسی و جواب دادن به کاربر نسبت به روزایی که به دانشگاه می رود است

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

#تابع بالا برای تایین منابع ترجیه داده شده و برگشت آن به کاربر است

d_univercity = None
l_mude = None

input (d_univercity)
input (l_mude)

p_days(d_univercity)  
p_bace(n_bace, l_mude)  