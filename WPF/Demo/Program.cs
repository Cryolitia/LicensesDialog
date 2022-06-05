using System;
using System.Collections.Generic;
using System.Windows;
using LicensesDialog;
using LicensesDialog.Licenses;

namespace Demo
{
    class Program
    {
        [STAThread]
        static void Main(string[] args)
        {
            Application app = new Application();
            List<Notice> notices = new();
            notices.Add(new Notice("LicenseDialog", "http://psdev.de/LicensesDialog", "Copyright 2013-2016 Philip Schiffer", new ApacheSoftwareLicense20()));
            app.Run(new LicensesDialog.LicensesDialog.Builder().SetNotices(notices).SetShowOwnLicense(true).Build());
        }
    }
}
