document.addEventListener("DOMContentLoaded", function () {
    const fieldSelect = document.getElementById("select-fl");

    // تابع برای نمایش/مخفی کردن بخش‌ها
    function toggleSections(selectedValue) {
        // لیست تمام دیوهای اصلی (boo, vid, brc)
        const mainDivs = ["boo", "vid", "brc"];

        mainDivs.forEach(mainDivId => {
            const mainDiv = document.getElementById(mainDivId);
            if (!mainDiv) return;

            // مخفی کردن تمام بخش‌های cun, ds, ace در این دیو
            mainDiv.querySelectorAll("#cun, #ds, #ace").forEach(section => {
                section.style.display = "none";
            });

            // نمایش بخش متناسب با انتخاب کاربر
            let targetSectionId;
            switch (selectedValue) {
                case "ce":
                    targetSectionId = "cun";
                    break;
                case "ac":
                    targetSectionId = "ds";
                    break;
                case "cn":
                    targetSectionId = "ace";
                    break;
                default:
                    return;
            }

            const targetSection = mainDiv.querySelector(`#${targetSectionId}`);
            if (targetSection) {
                targetSection.style.display = "block";
            }
        });
    }

    // رویداد تغییر روی dropdown
    fieldSelect.addEventListener("change", function () {
        toggleSections(this.value);
    });

    // مقدار پیش‌فرض (مهندسی کامپیوتر)
    toggleSections("ce");
});
