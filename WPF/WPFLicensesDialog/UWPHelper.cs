using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Media;
using Windows.Foundation.Metadata;
using Windows.UI.ViewManagement;

namespace LicensesDialog
{
    public class UWPHelper
    {
       
        public static UIColor getUIColor()
        {
            UIColor uiColor = new UIColor();
            try
            {
#pragma warning disable CA1416 // 验证平台兼容性
                if (ApiInformation.IsTypePresent("Windows.UI.ViewManagement.UISettings"))
                {

                    UISettings uiSettings = new UISettings();
                    Windows.UI.Color accentColor = uiSettings.GetColorValue(UIColorType.Accent);
                    uiColor.AccentColor = Color.FromRgb(accentColor.R,accentColor.G,accentColor.B);
                    Windows.UI.Color foregroundColor = uiSettings.GetColorValue(UIColorType.Foreground);
                    uiColor.TextColor = Color.FromRgb(foregroundColor.R, foregroundColor.G, foregroundColor.B);
                    Windows.UI.Color backgroundColor = uiSettings.GetColorValue(UIColorType.Background);
                    uiColor.BackgroundColor = Color.FromRgb(backgroundColor.R, backgroundColor.G, backgroundColor.B);
                    if (uiColor.BackgroundColor.R==0&& uiColor.BackgroundColor.G == 0&& uiColor.BackgroundColor.B == 0)
                    uiColor.Gray = Color.FromRgb(17, 17, 17);
                }
#pragma warning restore CA1416 // 验证平台兼容性
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
            }
            return uiColor;
        }

        public class UIColor
        {
            public Color AccentColor;
            public Color BackgroundColor;
            public Color TextColor;
            public Color Gray;

            public UIColor()
            {
                AccentColor = Color.FromRgb(66, 133, 244);
                BackgroundColor = Color.FromRgb(255, 255, 255);
                TextColor = Color.FromRgb(0, 0, 0);
                Gray = Color.FromRgb(238, 238, 238);
            }
        }

    }
}
