using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Windows;
using System.Windows.Documents;
using System.Windows.Media;
using System.Windows.Navigation;
using static LicensesDialog.UWPHelper;

namespace LicensesDialog
{
    public static class LicensesFlowDocumentBuilder
    {
        public static FlowDocument Build(List<Notice> notices, bool showFullLicenseText, UIColor uiColor)
        {
            FlowDocument flowDocument = new();
            Section section = new();
            section.Foreground = new SolidColorBrush(uiColor.TextColor);
            foreach (Notice notice in notices)
            {
                section.Blocks.Add(BuildLicenseSection(notice, showFullLicenseText,uiColor));
            }
            flowDocument.Blocks.Add(section);
            return flowDocument;
        }

        public static Section BuildLicenseSection(Notice notice, bool showFullLicenseText, UIColor uiColor)
        {
            Section section = new();
            List list = new();
            Span span = new Span();
            span.Inlines.Add(new Run(notice.Name));
            if (notice.Url!=null && notice.Url.Length > 0)
            {
                span.Inlines.Add(new Run(" ("));
                Hyperlink hyperlink = new Hyperlink(new Run(notice.Url));
                hyperlink.NavigateUri = new Uri(notice.Url);
                hyperlink.RequestNavigate += new RequestNavigateEventHandler(hlink_RequestNavigate);
                span.Inlines.Add(hyperlink);
                span.Inlines.Add(new Run(")"));
            }
            list.ListItems.Add(new ListItem(new Paragraph(span)));
            section.Blocks.Add(list);
            Section section2 = new();
            section2.FontFamily = new FontFamily("Global Monospace");
            section2.Background = new SolidColorBrush(uiColor.Gray);
            section2.Padding = new Thickness(10);
            if (notice.Copyright!=null && notice.Copyright.Length > 0)
            {
                section2.Blocks.Add(new Paragraph(new Run(notice.Copyright)));
                section2.Blocks.Add(new Paragraph());
            }
            string licenseText;
            if (showFullLicenseText)
            {
                licenseText = notice.License!.FullText;
            }
            else
            {
                licenseText = notice.License!.SummaryText;
            }
            section2.Blocks.Add(new Paragraph(new Run(licenseText)));
            section.Blocks.Add(section2);
            return section;
        }

        static void hlink_RequestNavigate(object sender, System.Windows.Navigation.RequestNavigateEventArgs e)
        {
            Process.Start(new ProcessStartInfo
            {
                FileName = e.Uri.AbsoluteUri,
                UseShellExecute = true
            });
            e.Handled = true;
        }
    }
}
