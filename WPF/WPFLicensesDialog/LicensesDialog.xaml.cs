using LicensesDialog.Licenses;
using System.Collections.Generic;
using System.Windows;
using System.Windows.Media;
using static LicensesDialog.UWPHelper;

namespace LicensesDialog
{
    /// <summary>
    /// LicenesDialogWindow.xaml 的交互逻辑
    /// </summary>
    public partial class LicensesDialog : Window
    {

        private string TitleText;
        private List<Notice> Notices;
        private bool ShowFullLicenseText;

        private void Init()
        {
            InitializeComponent();

            Title = TitleText;
            UIColor uiColor = UWPHelper.getUIColor();
            Background = new SolidColorBrush(uiColor.BackgroundColor);
            flowDocumentViewer.Document = LicensesFlowDocumentBuilder.Build(Notices, ShowFullLicenseText, uiColor);
        }

        private LicensesDialog(string titleText, List<Notice> notices, bool showFullLicenseText)
        {
            TitleText = titleText;
            Notices = notices;
            ShowFullLicenseText = showFullLicenseText;
        }

        public class Builder
        {
            private LicensesDialog dialog;
            private bool ShowOwnLicense;

            public Builder()
            {
                dialog = new LicensesDialog("Notices", new List<Notice>(), false);
            }

            public Builder(string titleText, List<Notice> notices, bool showFullLicenseText, bool showOwnLicense)
            {
                dialog = new LicensesDialog(titleText, notices, showFullLicenseText);
                ShowOwnLicense = showOwnLicense;
            }

            public Builder SetTitleText(string titleText)
            {
                dialog.TitleText = titleText;
                return this;
            }

            public Builder SetNotices(List<Notice> notices)
            {
                dialog.Notices = notices;
                return this;
            }

            public Builder SetShowFullLicenseText(bool showFullLicenseText)
            {
                dialog.ShowFullLicenseText=showFullLicenseText;
                return this;
            }

            public Builder SetShowOwnLicense(bool showOwnLicense)
            {
                ShowOwnLicense = showOwnLicense;
                return this;
            }

            public LicensesDialog Build()
            {
                if (ShowOwnLicense)
                {
                    dialog.Notices.Add(new Notice("LicensesDialog","https://github.com/Cryolitia/LicensesDialog","Copyright 2022 singleNeuron", new ApacheSoftwareLicense20()));
                }
                dialog.Init();
                return dialog;
            }
        }

    }
}
