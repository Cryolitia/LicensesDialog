using LicensesDialog.Licenses;

namespace LicensesDialog
{
    public class Notice
    {
        public string Name;
        public string Url;
        public string Copyright;
        public License License;

        public Notice() { }

        public Notice(string name, string url, string copyright, License license)
        {
            Name = name;
            Url = url;
            Copyright = copyright;
            License = license;
        }
    }
}
