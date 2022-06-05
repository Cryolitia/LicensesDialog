using System.IO;
using System.Reflection;

namespace LicensesDialog.Licenses
{
    public abstract class License
    {
        private string _cachedSummaryText;
        private string _cachedFullText;
        public abstract string Name { get; }
        public virtual string Version => "";
        public abstract string Url { get; }
        public virtual string Resource => null;

        public virtual string ReadSummaryTextFromResources() => ReadTextFromResources(Resource + "_summary");

        public virtual string ReadFullTextFromResources() => ReadTextFromResources(Resource + "_full");

        public string SummaryText
        {
            get
            {
                if (_cachedSummaryText == null)
                {
                    _cachedSummaryText = ReadSummaryTextFromResources();
                }

                return _cachedSummaryText;
            }
        }

        public string FullText
        {
            get
            {
                if (_cachedFullText == null)
                {
                    _cachedFullText = ReadFullTextFromResources();
                }

                return _cachedFullText;
            }
        }

        public override string ToString() => Name + ' ' + Version + ' ' + Url + '\n' + SummaryText;

        protected static string ReadTextFromResources(string name)
        {
            var assembly = Assembly.GetExecutingAssembly();
            var stream = assembly.GetManifestResourceStream(assembly.GetName().Name + ".licenses_full_text." + name + ".txt");
            StreamReader reader = new StreamReader(stream);
            return reader.ReadToEnd();
        }

    }
}